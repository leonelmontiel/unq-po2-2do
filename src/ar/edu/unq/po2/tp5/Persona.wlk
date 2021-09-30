class Persona{
	
	const property nombre
	const property fechaNacimiento
	
	method edad() = return ((new Date() - self.fechaNacimiento())/365).truncate(0)
	
	method esMenorQue(_persona){
		return self.edad() < _persona.edad()
	}	
}