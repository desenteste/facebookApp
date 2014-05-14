package br.ufsc.dsoo.controller;

import br.ufsc.dsoo.view.UserInterface;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

public class Authenticate {

	private ConfigurationBuilder cb;
	private Configuration conf;
	private FacebookFactory ff;
	private AccessToken accessToken;

	
	public Authenticate() {
		
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthAppId("1425176727742295")
		  .setOAuthAppSecret("1b94f6a852e990eac1c80a427c5a1fd0")
		  .setOAuthPermissions("read_mailbox,email,publish_stream,user_relationships,friends_relationships,user_birthday,friends_birthday,user_friends,read_friendlists,"
		  		+ "rsvp_event,user_events,create_event,user_location,user_tagged_places,manage_friendlists,public_profile");
		conf = cb.build();
	}
	
	public Facebook FacebookAuth(UserInterface ui) {
		
		ff = new FacebookFactory(conf);
		Facebook facebook = ff.getInstance();
		try {
			accessToken = facebook.getOAuthAccessToken(ui.insertOAuthAcessToken(facebook));
			facebook.setOAuthAccessToken(accessToken);
			try {
				if (!facebook.getAuthorization().isEnabled()) {
					ui.showMessage("Erro ao conectar. Tente novamente!");
					ui.insertOAuthAcessToken(facebook);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch (FacebookException e) {
			ui.showMessage("Código de acesso inválido. Tente novamente!");
			ui.insertOAuthAcessToken(facebook);
		}
		ui.showMessage("Conexão efetuada com sucesso!");
		return facebook;
	}
}
