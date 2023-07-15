package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.Version;



public interface VersionService {

	public List<Version> getListVersion();

	public Version save(Version version);


	public Version update(Version version);


	public void deleteById(Integer versionId);

	public Version findVersionById(Integer versionId);

}
