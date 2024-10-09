package packUser;

import packExceptions.*;

public class Person {

	// id should be unique for each person. Careful with the possible exception.
	private String id;
	private String name;
	private String lastname;
	private String birthdate;
	private String gender;
	private String birthplace;
	private String home;
	private String[] studiedat;
	private String[] workplaces;
	private String[] films;
	private String[] friendships;
	private String groupcode= "G612498";
	
	
	// Id son únicos, se debe verificar primeramente.

	// Cada uno de los atributos pueden ser vacíos, a excepcion de ID 

	// Tratar las excepciones puede ser incoveniente si seguimos criterios distintos a la input data de nuestros compañeros
	// he mirado y por ejemplo muchos utilizan fechas como "1-1-1920" en vez de "01-01-1920" o intercambiar de posicion meses y dias
	// Voy a considerar, que los datos introducidos, serán "razonablemente" correctos.
	
	
	
	// Cuidado, diferenciar una string vacía y una string no inicializada(null). Son tratados de forma diferente. Depende como haga la lectura
	// loadUsers() --> Cambia la excepcion.
	
	public Person(String pId,String pName,String pLastName,String pBirthDate,String pGender,String pBirthPlace, String pHome, String[] pStudieDat, String[] pWorkPlaces, String[] pFilms, String pGroupcode) throws EmptyID{
		
		if(pId==null) {
			throw new EmptyID();
		}
		/*
		 * Se debe verificar en la Lista que 
		else if(List.IDrepeated()) {
			throw new ExistingID();
		}
		*/
		else {
			id=pId;
			name=pName;
			lastname=pLastName;
			birthdate=pBirthDate;
			gender=pGender;
			birthplace=pBirthPlace;
			home=pHome;
			studiedat=pStudieDat;
			workplaces=pWorkPlaces;
			films=pFilms;
			//After reading "friends.txt" --> Relations among users are created in each person atribute "friendships".
			friendships=null;
			groupcode=pGroupcode;
		}

	
		
			
	}
	
	// Getters and Setters can be implemented depending on the Social Network posibilities. Maybe we want to know only someone id.
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		
		String StudieDat = new String();
		String WorkPlaces = new String();
		String Films = new String();
		String Friendships = new String();
		
		//Array to String Transformation of studiedat

		try {
		for (int i=0;i<this.studiedat.length;i++) {
			StudieDat+=this.studiedat[i]+",";
		}
		// Replacing last character of the String, "," --> ";" 
		StudieDat=StudieDat.substring(0,StudieDat.length()-1)+";";
		}
		catch(NullPointerException e) {
			StudieDat=";";
		}
		
		try {
		for (int i=0;i<this.films.length;i++) {
			Films+=this.films[i]+",";
		}
		Films=Films.substring(0,Films.length()-1)+";";
		}
		catch(NullPointerException e) {
			WorkPlaces=";";
		}
		
		try {
		for (int i=0;i<this.workplaces.length;i++) {
			WorkPlaces+=this.workplaces[i]+",";
		}
		WorkPlaces=WorkPlaces.substring(0,WorkPlaces.length()-1)+";";
		}
		catch(NullPointerException e ) {
			Films=";";
		}
		/*
		try{
		for (int i=0;i<this.friendships.length;i++) {
			Friendships+=this.friendships[i]+",";
		}
		Friendships=Friendships.substring(0,Friendships.length()-1)+";";
		}
		catch(NullPointerException e){
			Friendships="";
		}
		*/
		

		return this.id+","+this.name+","+this.lastname+","+this.birthdate+","+this.gender+","+this.birthplace+","+this.home+","+StudieDat+WorkPlaces+Films+this.groupcode;

		//return this.id+" "+this.name+","+this.lastname+","+this.birthdate+","+this.gender+","+this.birthplace+","+this.home+","+StudieDat+WorkPlaces+Films+Friendships+this.groupcode;
		

	}
		
}
