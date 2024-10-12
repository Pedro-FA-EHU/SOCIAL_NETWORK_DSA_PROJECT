public static void removeUserFriendships(Person s) {
	    try {
	        boolean userFriendFound = false;
	        int j = 0;
	        for (int i = 0; i < s.getFriendships().split(",").length; i++) {
	            while (!userFriendFound && j < userList.size()) {
	                if (userList.getElement(j).getId().equals(s.getFriendships().split(",")[i])) {
	                    userFriendFound = true;
	                    userList.getElement(j).setFriendships(userList.getElement(j).getFriendships().replace(s.getId(), ""));
	                    // In case 2 comas
	                    userList.getElement(j).setFriendships(userList.getElement(j).getFriendships().replace(",,", ","));
	                    //In case the first	 letter of friendship atribute is coma
	                    if (userList.getElement(j).getFriendships().charAt(0) == ',') {
	                        userList.getElement(j).setFriendships(userList.getElement(j).getFriendships().substring(1));
	                    }
	                    //In case the last letter of friendship atribute is coma
	                    if (userList.getElement(j).getFriendships().charAt(userList.getElement(j).getFriendships().length() - 1) == ',') {
	                        userList.getElement(j).setFriendships(userList.getElement(j).getFriendships().substring(0, userList.getElement(j).getFriendships().length() - 1));
	                    }
	                } else {
	                    j++;
	                }
	            }
	            userFriendFound = false;
	            j = 0;

	        }
	    } catch (EmptyCollectionException e) {
	        System.out.println(e.getMessage());
	    } catch (AccessOutOfBoundariesException e) {
	        System.out.println(e.getMessage());
	    }
	}

	public static void removeUser() {
		
		try {
		System.out.println("Introduce user ID to remove : ");
		String user=input.nextLine();
		boolean userFound=false;
		int i=0;
		while(!userFound && i<userList.size()) {
			if(userList.getElement(i).getId().equals(user)) {
				userFound=true;
				Person p=userList.getElement(i);
				userList.remove(p);
				removeUserFriendships(p);
			}
			else{
				i++;
			}
		}
		if(!userFound) {
			throw new UnregisteredIDException();
		}

		}
		catch(AccessOutOfBoundariesException e) {
			System.out.println(e.getMessage());
		}
		catch(EmptyCollectionException e) {
			System.out.println(e.getMessage());
		}
		catch(UnregisteredIDException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
