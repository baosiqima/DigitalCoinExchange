package com.digitalcoinexchange.User.Security;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
	  // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "ACc69d6b59c920f06c334b94ef954804aa";
    public static final String AUTH_TOKEN =
            "e171d546f42ad7da51d950c9b0c775be";

    String s="sfadgffes";
    public void m1(String mobile,String token)
    {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(mobile), // to
                        new PhoneNumber("+1 281-843-9384 "), // from
                        token)
                .create();

        System.out.println(message.getSid());
    }

}
