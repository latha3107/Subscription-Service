import java.util.*;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Subscription_Service {
	
	private static final DateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
	private static final String[] subscription_choices = { "DAILY", "WEEKLY", "MONTHLY"};
	private static final Calendar c = Calendar.getInstance();
	
	public static void main(String[] args) throws ParseException {
		String[] invoice_date = null;
        String subscription_last_date = null;
		String input_amount = JOptionPane.showInputDialog(null," Enter Amount $: ");
		
		while(!isValidInteger(input_amount)) {
			input_amount = JOptionPane.showInputDialog("Kindly input a valid amount! Enter Amount $: ");
        }
		
		if(input_amount != null)  
        {
			double amount = Double.parseDouble(input_amount);
			String input_date = JOptionPane.showInputDialog("Enter Invoice Dates DD/MM/YYYY: ");
			
			while(!isValidDate(input_date)) {
            	input_date = JOptionPane.showInputDialog("Kindly input a valid invoice date! Enter Invoice Dates DD/MM/YYYY: ");
            }
			
			if(input_date != null) {
	    	    String subscription_type = (String) JOptionPane.showInputDialog(null, "Enter Subscription Type : ","",JOptionPane.QUESTION_MESSAGE, null, subscription_choices, subscription_choices[0]); 
	    	    
	    	    if(subscription_type != null) {
	    	    	invoice_date = getInvoiceDates(input_date,subscription_type);

		    		subscription_last_date = invoice_date[invoice_date.length-1];
		        	
		            JOptionPane.showMessageDialog(null, "A "+subscription_type+" subscription every Tuesday for "+amount+" $ from the "+input_date+" to the "+subscription_last_date+" will have the following invoice dates: "+Arrays.toString(invoice_date));
	    	    }
			}
        }
        
        System.exit(0);
	}
	
	public static boolean isValidInteger(String input) {
		
		try {
        	if(input != null) {
        		Integer.parseInt(input); 
            }
        	else {
        		return true;
        	}
        } catch (NumberFormatException  e) {
            return false;
        }
		
		return true;
	}
	
	public static boolean isValidDate(String date) {
        date_format.setLenient(false);
        
        try {
        	if(date != null) {
        		date_format.parse(date);
            }
        	else {
        		return true;
        	}
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	public static String[] getInvoiceDates(String invoice_date, String subscription_type) {
        int count = 0;
        var manipulation_type = Calendar.DATE;
        
		if (subscription_type == "DAILY") {
			count = 7;
	    }else if (subscription_type == "WEEKLY") {
	    	count = 4;
	    	manipulation_type = Calendar.DATE;
	    } else if (subscription_type == "MONTHLY") {
	    	count = 3;
	    	manipulation_type = Calendar.DATE;
	    }	
		
		String[] date = new String[count];
    	for (int i = 0; i < count; i++) {
    		try {
    			c.setTime(date_format.parse(invoice_date));
    		} catch(ParseException e) {
    			e.printStackTrace();
    		}
    		
    		c.add(manipulation_type,i);
    		date[i]= date_format.format(c.getTime());
    	}
    	
    	return date;
	}

}