package com.basics.factory;

public class CourseFactoryImpl implements CourseFactory {

	@Override
	public void getThomsonOrFirmCourses(String ThomsonOrFirm) {
		if(null != ThomsonOrFirm){
			if(ThomsonOrFirm.equalsIgnoreCase("thomson")){
				ThomsonOnDemand thomObj = new ThomsonOnDemand();
				thomObj.getThomsonCourses();
			}else if(ThomsonOrFirm.equalsIgnoreCase("firm")){
				FirmOnDemand firmObj = new FirmOnDemand();
				firmObj.getfirmCourses();
			}
		}
	}

}
