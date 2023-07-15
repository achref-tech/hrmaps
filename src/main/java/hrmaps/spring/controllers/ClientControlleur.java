package hrmaps.spring.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.UploadImageClient;
import hrmaps.spring.repositories.ImageClientRepository;
import hrmaps.spring.servicesImp.ClientServiceImp;



@RestController
@RequestMapping("/client")
@CrossOrigin(origins="*")
public class ClientControlleur {

	@Autowired
	private ClientServiceImp clientService;
	@Autowired
	 ImageClientRepository imageRep;

	@GetMapping(value = "/clients", produces = "application/json")
	public List <Client> getAllClients() {
		return clientService.findAll();
	}

	@PostMapping(value = "/add-client", produces = "application/json")
	public Client saveClient( 
			@RequestParam("image") MultipartFile file,
			@RequestParam("clientVolonte") Double clientVolonte,
			@RequestParam("clientDescription") String clientDescription
			
	         ) throws IOException {
		Client client = new Client();
		
		client.setClientDateDebutDemande(new Date());
		client.setClientDescription(clientDescription);
		client.setClientDateFinDemande(new Date());
		client.setClientVolonte(clientVolonte);
		
		UploadImageClient img = new UploadImageClient();
        img.setData(file.getBytes());
        UploadImageClient savedImg = this.imageRep.save(img);
        client.setImage(savedImg);
		 
		return clientService.save(client);
	}
	@DeleteMapping(value = "/clients/{s}", produces = "application/json")
	public void findById(@PathVariable int s) {
		clientService.deleteById(s);
	}
	
	@GetMapping(value = "/client/{id}", produces = "application/json")
	public Client getClientById(@PathVariable int id) {
		return clientService.findById(id);
	} 
    @PutMapping(value = "/client", produces = "application/json")
	public void updateClient( @RequestBody Client client) {
		clientService.changeEtatClient(1, client);
	}
	
	
	@PutMapping(value = "/clientt/{idVersion}", produces = "application/json")
	public void affecterVersionClient(@PathVariable int idVersion,  @RequestBody Client client) {
				System.out.println("##### idVersion == " + idVersion);
				System.out.println("##### client == " + client.toString());
				clientService.affecterVersionClient(idVersion, client);
	}
	
  
    	
    	
    
    
	@PostMapping("/file")
    @ResponseBody
    @Transactional
    public Object  uploadImg (@RequestParam("file") @Nullable MultipartFile file,@RequestParam(value="identifier",required=false)int id) {
		
        Client client=clientService.findById(id);
        if(client==null)
        {
            Map<String, String> errorDetails= new HashMap<>();
            errorDetails.put("message", "client non definit");
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
        if(file!=null) {
            UploadImageClient image =client.getImage();

            if(image==null)
            {
                image= new UploadImageClient();
                image.setClient(client);
                client.setImage(image);
            }

            try {
                image.setData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setName(file.getOriginalFilename());

            clientService.saveImage(image);

            clientService.changeEtatClient(1, client);
        }


        return client;
    }
	
	@GetMapping("/retrieve-maxversion")
    public List<Client> findClientByRecentVersion() {
        return clientService.findClientByRecentVersion();
        }
	
	

}

