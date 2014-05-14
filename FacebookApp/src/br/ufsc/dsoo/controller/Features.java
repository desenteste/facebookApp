package br.ufsc.dsoo.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import br.ufsc.dsoo.view.UserInterface;
import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Friend;
import facebook4j.Friendlist;
import facebook4j.GroupMember;
import facebook4j.Paging;
import facebook4j.PostUpdate;
import facebook4j.Reading;
import facebook4j.ResponseList;

public class Features {

	public void setOpenBarEventAsAttending(Facebook facebook, UserInterface ui) {
		
		String message = "";
		ResponseList<Event> events = new ResponseList<Event>() {
			
			@Override
			public <T> T[] toArray(T[] arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Event> subList(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Event set(int arg0, Event arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean retainAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Event remove(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean remove(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ListIterator<Event> listIterator(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListIterator<Event> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int lastIndexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Iterator<Event> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int indexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Event get(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(int arg0, Collection<? extends Event> arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean addAll(Collection<? extends Event> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void add(int arg0, Event arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean add(Event arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Paging<Event> getPaging() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getCount() {
				// TODO Auto-generated method stub
				return null;
			}
		}; 
		
		try {
			events = facebook.getEvents();
			for (int i = 0; i < events.size(); i++) {
				if((events.get(i).getName().toLowerCase().contains("open bar")) || (events.get(i).getName().toLowerCase().contains("open food"))) {
					if(!events.get(i).getRsvpStatus().equalsIgnoreCase("attending")){
						facebook.events().rsvpEventAsAttending(events.get(i).getId());
						message = message + "\n" + "Presença no evento " + events.get(i).getName() + " confirmada!";
					}
				}
			}
		} catch (FacebookException e1) {
			e1.printStackTrace();
		}
		if(message.isEmpty()){
			ui.showMessage("Não há nenhum evento a ser confirmado!");
		} else {
			ui.showMessage(message);
		}
		ui.showApplicationOptions(facebook);
	}

	public void postTaggingAllFriends(Facebook facebook, UserInterface ui) {
		
		ResponseList<Friend> friends = new ResponseList<Friend>() {
			
			@Override
			public <T> T[] toArray(T[] arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Friend> subList(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Friend set(int arg0, Friend arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean retainAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Friend remove(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean remove(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ListIterator<Friend> listIterator(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListIterator<Friend> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int lastIndexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Iterator<Friend> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int indexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Friend get(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(int arg0, Collection<? extends Friend> arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean addAll(Collection<? extends Friend> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void add(int arg0, Friend arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean add(Friend arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Paging<Friend> getPaging() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getCount() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		PostUpdate pu = null;
		try {

			friends = facebook.getFriends(new Reading().fields("name,gender,bio"));
			
			pu = new PostUpdate(JOptionPane.showInputDialog("Digite a mensagem que será postada em seu Feed"));
			pu.setTags("");
			for (int i = 0; i < friends.size(); i++) {
				if(pu.getTags().isEmpty()) {
					pu.setTags(friends.get(i).getId());
				}else{
					pu.setTags(pu.getTags() + "," + friends.get(i).getId());
				}
			}
			pu.setPlace(facebook.getMe().getLocation().getId());
			facebook.postFeed(facebook.getMe().getId(), pu);
			ui.showMessage("Postagem efetuada com sucesso.");
		} catch (FacebookException e) {
			e.printStackTrace();
		}
		ui.showApplicationOptions(facebook);

	}
		
	public void groupMemberByGender(Facebook facebook, UserInterface ui) {

		ResponseList<GroupMember> group = new ResponseList<GroupMember>() {
			
			@Override
			public <T> T[] toArray(T[] arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<GroupMember> subList(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public GroupMember set(int arg0, GroupMember arg1) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean retainAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean removeAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public GroupMember remove(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean remove(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ListIterator<GroupMember> listIterator(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ListIterator<GroupMember> listIterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int lastIndexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Iterator<GroupMember> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int indexOf(Object arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public GroupMember get(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsAll(Collection<?> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean contains(Object arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean addAll(int arg0, Collection<? extends GroupMember> arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean addAll(Collection<? extends GroupMember> arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void add(int arg0, GroupMember arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean add(GroupMember arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Paging<GroupMember> getPaging() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer getCount() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		Friendlist flMale = null;
		Friendlist flFemale = null;
		Friendlist flUndefined = null;
		
		try {
			group = facebook.getGroupMembers("416406598500485", new Reading().fields("name,gender"));
			flMale = facebook.friends().getFriendlist("1387560021530959");
			flFemale = facebook.friends().getFriendlist("1387561001530861");
			flUndefined = facebook.friends().getFriendlist("1387561908197437");
		} catch (Exception e) {
			e.printStackTrace();
		}
			for (int i = 0; i < group.size(); i++) {
				try {
					if(group.get(i).getGender().equalsIgnoreCase("male")){
						facebook.addFriendlistMember(flMale.getId(), group.get(i).getId());
					} else if(group.get(i).getGender().equalsIgnoreCase("female")) {
						facebook.addFriendlistMember(flFemale.getId(), group.get(i).getId());
					}
				} catch (NullPointerException e) {
					try {
						facebook.addFriendlistMember(flUndefined.getId(), group.get(i).getId());
					} catch (FacebookException e1) {
						e1.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			ui.showMessage("Operação concluída com sucesso!");
			ui.showApplicationOptions(facebook);		
	}
}
