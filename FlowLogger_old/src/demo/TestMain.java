package demo;

public class TestMain {

	public static void main(String[] args) {
	   
/*//		CA:DEBUG 12:55:00:884 ActionExecutor - Finished executing [SetAction@fe7fb0 name = flowScope.usedLoginPage, value = false]; result = success
		//String str = "ActionExecutor - Finished executing [EvaluateAction@128a415 expression = loginProcessor.contingencyLogin(flowModel, externalContext), resultExpression = [null]]; result = no";
         String str ="CA:DEBUG 12:55:00:889 ActionExecutor - Finished executing [EvaluateAction@7108a1 expression = loginProcessor.validateReferringUrl(externalContext.nativeRequest), resultExpression = [null]]; result = success";
		
//		String [] strArr = str.split("[]");
	    char[] charArr = str.toCharArray();
		for(int i=0;i<charArr.length;i++)
		{
			System.out.println("["+i+"]"+charArr[i]);
		}
		
		int index=str.indexOf("=");
		int index1=str.indexOf(",");
		
		
		
		
		System.out.println("Exp index:"+index);
		System.out.println("Output:"+str.substring(index+2, index1));
		str.lastIndexOf('"');
		int index= str.indexOf("result ");
//		int index1= str.lastIndexOf("");
		System.out.println("Output:"+str.substring(index+9, str.length()));
//		System.out.println("Exp index:"+index1);
         int count=0;
         for(String st:strArr)
         {
        	 System.out.println("StrArr["+count+"]:"+st);
        	 count++;
         }*/
		
		//---------CA:DEBUG 13:09:52:115 ActionExecutor - Finished executing [EvaluateAction@1d193c9 expression = loginProcessor.isGlobalCA:WARN  13:09:52:136 FlowScope - Destruction callback for 'flowModel' was not registered. Spring Web Flow does not support destruction of scoped beans.
		
		
		/*String str ="loginProcessor.validateReferringUrl(externalContext.nativeRequest)";
		String [] strArr = str.split("\\.",2);
		for(String st:strArr)
		{
			System.out.println(st);
		}*/
		
		
		/*String str ="TCPA:DEBUG - ViewState - Rendering + [ServletMvcView@1d6c6da view = org.springframework.webflow.mvc.view.FlowAjaxTilesView: name 'tcpaTest_def'; URL [tcpaTest_def]]";
		
		int index=str.indexOf("name");
		int endIndex = str.indexOf(";");
		
		String s= str.substring(index+6,endIndex-1);
		
		System.out.println(s);*/
		
		/*String [] strArr = str.split("\\.",2);
		
		for(String st:strArr)
		{
			System.out.println(st);
		}
		*/
		
		//TCPA:DEBUG - ActionExecutor - Executing [EvaluateAction@816b21 expression = tcpaProcessor.populateDetails(flowModel, ecis, banker, standaloneMode, lobCode, channelCode), resultExpression = [null]]
		//TCPA:DEBUG - ActionExecutor - Executing [EvaluateAction@5fd37 expression = tcpaForm.setFormsOnSession(externalContext)
		
		//TCPA:DEBUG - SubflowState - Calling subflow 'tcpa-flow' with input map['standaloneMode' -> true, 'channelCode' -> '1', 'ecis' -> list['0260358593'], 'customer' -> [null], 'lobPreferenceViewSupported' -> true, 'lobCode' -> '2', 'banker' -> com.chase.arc.session.model.domain.UserModel@69d]
		
		String str="TCPA:DEBUG - Transition - Executing [Transition@9a5663 on = continue, to = customerSearch]";
		int startIndex= str.indexOf("on =");
		int endIndex= str.indexOf(", to");
		System.out.println("it is:"+str.substring(startIndex+5,endIndex));
		
         
	}

}
