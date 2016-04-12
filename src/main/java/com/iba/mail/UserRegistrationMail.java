package com.iba.mail;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGrid.Email;

public class UserRegistrationMail {

	public void sendMail(){
		SendGrid sendgrid = new SendGrid("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");
        Email email = new Email();
        email.addTo(this.p.get(0).getemail());
        email.addToName(this.p.get(0).getfirstName());
        email.addCc(cc);
        email.setFrom("Galepartners.com");
        
        email.setSubject("Happy Birthday Wishes sent from spring app");
//        email.add
//        email.setText("My first email through SendGrid");
//        email.setHtml("<H1>Hello</H1><img src=\"http://www.happybirthdaywishes-images.com/wp-content/uploads/2015/05/Happy-Birthday-Wishes-friends.jpg\");
        email.setText("Happy Birthday");
        email.setHtml("<p>Hi "+"<b1>"+this.p.get(0).getfirstName() +"<b1>"+" GALE Team wishes you Happy Birthday, May your coming year surprise you with the happiness of smiles, the feeling of love and so on. We hope you will find plenty of sweet memories to cherish forever.</p>" +"<img src=\"http://www.happybirthdaywishes-images.com/wp-content/uploads/2015/05/Happy-Birthday-Wishes-friends.jpg\">");
        
        System.out.println(p.size());
        try {
            SendGrid.Response response = sendgrid.send(email);
            System.out.println("Sent");
        } catch (SendGridException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Failed");
        }
	}
}
