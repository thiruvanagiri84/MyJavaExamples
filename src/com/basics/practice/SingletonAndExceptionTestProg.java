package com.basics.practice;

public class SingletonAndExceptionTestProg {

	public static void main(String[] args) {
		SingletonProg singletonObj1 = SingletonProg.getMySingletonInstance();
		SingletonProg singletonObj2 = SingletonProg.getMySingletonInstance();
		SingletonProg singletonObj3 = SingletonProg.getMySingletonInstance();
		
		try{
			singletonObj1.singletonTestMethod();
			singletonObj2.singletonTestMethod();
			singletonObj3.singletonTestMethod();
		}catch(RootElementException re){
			/* In CPL, think this file as Handler and RootElementException is originated from EJB file(here its SingletonProg.java file). 
			 * In EJB, we catch Pre-Defined exceptions like SQL exception and throw new Custom Exception like RootElementException
			 * In Handler, we catch Custom Exceptions and handle it by displaying error.jsp page as shown below. 
			 */
			re.printStackTrace();
			String msg = "In CPL, we use this message to display on error.jsp file";
			/*request.setAttribute("error_msg_key",msg);
			next = "error.jsp";*/
		}
		
		//In CPL EJB files
		/*catch (SQLException se) {
			throw new ApplicationException("Failed in retrieving data from DB, Exception message: " + se.getMessage());

		}*/
		
		//OR, we can throw our custome exceptions in our service layer(Business logic) as shown below.
		/*if (!root.getTagName().equals("student")) {
            throw new RootElementException("Invalid root tag <" + root.getTagName() +"> in the xml string.");
        }*/
		
		//In CPL handlers.
		/*catch (ApplicationException ae) {
			String msg = "Failed in getting list of In-Process Activities due to "
					+ "error occurred at application level.  "
					+ ae.getMessage();
			logger.debug(msg);
			request.setAttribute(SiteConsts.ERR_MESSAGE_KEY, msg);
			next = SiteConsts.ERROR_URL_PROF;
		}*/
		
		singletonObj1.x = 10;
		System.out.println(singletonObj2.x); // will return 10 always for any object since its static reference object, one per class
	}

}
