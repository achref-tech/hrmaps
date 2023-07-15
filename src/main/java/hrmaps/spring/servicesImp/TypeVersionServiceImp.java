package hrmaps.spring.servicesImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.TypeVersion;
import hrmaps.spring.repositories.TypeVersionRepository;
import hrmaps.spring.services.TypeVersionService;


@Service
@Transactional
public class TypeVersionServiceImp implements TypeVersionService {

	@Autowired
	private TypeVersionRepository typeVersionRepository;

	@Override
	public List<TypeVersion> getListTypeVersion() {
		return typeVersionRepository.findAll();
	}

	@Override
	public TypeVersion save(TypeVersion typeVersion) {
		return typeVersionRepository.save(typeVersion);
	}

	@Override
	public TypeVersion update(TypeVersion typeVersion) {
		return typeVersionRepository.save(typeVersion);
	}

	@Override
	public void deleteById(Integer typeVersionId) {
		typeVersionRepository.deleteById(typeVersionId);
	}

	@Override
	public TypeVersion findTypeVersionById(Integer typeVersionId) {
		return typeVersionRepository.findById(typeVersionId).get();
	}

}

