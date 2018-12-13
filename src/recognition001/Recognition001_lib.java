package recognition001;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectFacesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;

public class Recognition001_lib {
	
	VisualRecognition service;
	IamOptions iamOptions;
	
	public Recognition001_lib(){
	this.service = new VisualRecognition("2018-03-19");
	this.iamOptions = new IamOptions.Builder()
	  .apiKey("aa")
	  .build();
	service.setIamCredentials(iamOptions);
	}

public void getResult(String aa) {
	DetectFacesOptions detectFacesOptions = null;
	try {
	detectFacesOptions = new DetectFacesOptions.Builder()
			  .imagesFile(new File("img/aa.jpg"))
			  .build();
	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	DetectedFaces result = service.detectFaces(detectFacesOptions).execute();
		System.out.println(result);
		
}
}
