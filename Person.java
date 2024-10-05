package packProject;

public class Person {

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

	// studiedat, workplaces,films y friendships , podrán ser elementos vacíos. 

	// Tratar las excepciones puede ser incoveniente si seguimos criterios distintos a la input data de nuestros compañeros
	// he mirado y por ejemplo muchos utilizan fechas como "1-1-1920" en vez de "01-01-1920" o intercambiar de posicion meses y dias
	// vamos a tratar solo las básicas, para evitar posibles errores y supondremos que input sea correcto. Presupongo que todos los 
	// datos básicos ( id, name, ...) no serán vacíos.
	
	public Person(String pId,String pName,String pLastName,String pBirthDate,String pGender,String pBirthPlace, String pHome, String[] pStudieDat, String[] pWorkPlaces, String[] pFilms, String pGroupcode) {

		
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
		groupcode=pGroupcode;
		
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

		for (int i=0;i<this.studiedat.length;i++) {
			StudieDat+=this.studiedat[i]+",";
		}
		// Replacing last character of the String, "," --> ";" 
		StudieDat=StudieDat.substring(0,StudieDat.length()-1)+";";
		
		for (int i=0;i<this.films.length;i++) {
			Films+=this.films[i]+",";
		}
		Films=Films.substring(0,Films.length()-1)+";";
		
		for (int i=0;i<this.workplaces.length;i++) {
			WorkPlaces+=this.workplaces[i]+",";
		}
		WorkPlaces=WorkPlaces.substring(0,WorkPlaces.length()-1)+";";
		
		for (int i=0;i<this.friendships.length;i++) {
			Friendships+=this.friendships[i]+",";
		}
		Friendships=Friendships.substring(0,Friendships.length()-1)+";";
		
		return this.id+" "+this.name+","+this.lastname+","+this.birthdate+","+this.gender+","+this.birthplace+","+this.home+","+StudieDat+WorkPlaces+Films+Friendships+this.groupcode;
		

	}
		
}
