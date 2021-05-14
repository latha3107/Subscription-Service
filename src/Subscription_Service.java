import java.util.*;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Subscription_Service {
	
	public static void main(String[] args) throws ParseException {
		
		double amount = Double.parseDouble(JOptionPane.showInputDialog(null," Enter Amount $: "));
		//System.out.println(amount);
		
        String invoice_date = JOptionPane.showInputDialog("Enter Invoice Dates DD/MM/YYYY: ");
        String[] newInvoiceDate = null;
        //System.out.println(invoice_date);

        SimpleDateFormat check_inv_date=new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar g=new GregorianCalendar();
        StringTokenizer t=new StringTokenizer(invoice_date,"/");
        String inv_4=t.nextToken();
        int inv_date=Integer.parseInt(inv_4);
        boolean check=g.isLeapYear(inv_date);
        //System.out.println("check : "+check);
        if(check == false) {
        	invoice_date = JOptionPane.showInputDialog("Kindly input a valid invoice date! Enter Invoice Dates DD/MM/YYYY: ");
            //System.out.println(invoice_date);
        }
        
		String[] subs_choices = { "DAILY", "WEEKLY", "MONTHLY"};
	    String subs_type = (String) JOptionPane.showInputDialog(null, "Enter Subscription Type : ","",JOptionPane.QUESTION_MESSAGE, null, subs_choices, subs_choices[0]); 
	    //System.out.println(subs_type);
	    
	    if (subs_type == "DAILY") {
	    	//System.out.println("You chose DAILY "+invoice_date);
	    	
	    	for (int i = 0; i < 7; i++) {

	    	    // add days for 1 week
	    		Calendar c = Calendar.getInstance();
	    		try {
	    			c.setTime(check_inv_date.parse(invoice_date));
	    		} catch(ParseException e) {
	    			e.printStackTrace();
	    		}
	    		c.add(Calendar.DAY_OF_MONTH,i);
	    		
	    		newInvoiceDate = new String[7];
	    		newInvoiceDate[i]= check_inv_date.format(c.getTime());
	    		System.out.println("newInvoiceDate[i]: "+newInvoiceDate[i]);
	    		System.out.println("array: "+Arrays.toString(newInvoiceDate));
	    		
	    	}
	    	
	    } else if (subs_type == "WEEKLY") {
	    	//System.out.println("You chose WEEKLY "+invoice_date);
	    	
	    	for (int i = 0; i < 4; i++) {

	    	    // add weeks for 1 month
	    		Calendar c = Calendar.getInstance();
	    		try {
	    			c.setTime(check_inv_date.parse(invoice_date));
	    		} catch(ParseException e) {
	    			e.printStackTrace();
	    		}
	    		c.add(Calendar.WEEK_OF_MONTH,i);
	    		
	    		newInvoiceDate = new String[4];
	    		newInvoiceDate[i]= check_inv_date.format(c.getTime());
	    		//System.out.println("array: "+Arrays.toString(newInvoiceDate));
	    		
	    	}
	    	
	    } else if (subs_type == "MONTHLY") {
	    	//System.out.println("You chose MONTHLY "+invoice_date);
	    	
	    	for (int i = 0; i < 3; i++) {

	    	    // add weeks for 1 month
	    		Calendar c = Calendar.getInstance();
	    		try {
	    			c.setTime(check_inv_date.parse(invoice_date));
	    		} catch(ParseException e) {
	    			e.printStackTrace();
	    		}
	    		c.add(Calendar.MONTH,i);
	    		
	    		newInvoiceDate = new String[3];
	    		newInvoiceDate[i]= check_inv_date.format(c.getTime());
	    		//System.out.println("array: "+Arrays.toString(newInvoiceDate));
	    		
	    	}
	    }
	    
    	for (int j = 0; j < newInvoiceDate.length; j++) {
    		//System.out.println("newInvoiceDate.length: "+newInvoiceDate.length);
    		//System.out.println("newInvoiceDate: "+newInvoiceDate[j]);
    	
        JOptionPane.showMessageDialog(null, "A "+subs_type+" subscription every Tuesday for "+amount+" $ from the "+invoice_date+" will have the following invoice dates: "+Arrays.toString(newInvoiceDate));
        System.exit(0);
    	}
              
	}

}