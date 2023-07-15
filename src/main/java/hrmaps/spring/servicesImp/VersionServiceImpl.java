package hrmaps.spring.servicesImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Version;
import hrmaps.spring.repositories.VersionRepository;
import hrmaps.spring.services.VersionService;

@Service

@Transactional
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionRepository versionRepository;


	@Override
	public List<Version> getListVersion() {
		return versionRepository.findAll();
	}

	@Override
	public Version save(Version version) {
		Version versionajoute = versionRepository.save(version);

		return versionajoute;
	}



	@Override
	public Version update(Version version) {

		return versionRepository.save(version);
	}

	
	@Override
	public void deleteById(Integer versionId) {
		versionRepository.deleteById(versionId);
	}

	@Override
	public Version findVersionById(Integer versionId) {
		return versionRepository.findById(versionId).get();
	}

}

