package uk.co.ratedpeople;

import java.util.List;

import uk.co.ratedpeople.SpecialisationTypeWrapper.SpecialisationType;

public class PrimaryTradeListBuilder {

	public static SpecialisationTypeWrapper build(List<Integer> specialisationTypeId) {
		SpecialisationTypeWrapper obj = new SpecialisationTypeWrapper();
		
		for(Integer id : specialisationTypeId){
			SpecialisationType specType = new SpecialisationType();
			specType.setId(id);
			obj.getSpecialisationTypeList().add(specType);
		}
		
		return obj;
	}
}

