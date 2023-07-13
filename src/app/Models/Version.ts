import { VersionType } from "./VersionType";

export class Version{
    versionId!:String;
	versionLibelle!:string;
	versionEmplacement!:string;
	versionType!:VersionType;
	versionResponsable!:string;
	versionEmailResponsable!:string;
}