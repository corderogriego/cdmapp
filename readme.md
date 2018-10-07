Buenas David, te explico un poco como he hecho para que puedas ver las consultas que guarda en archivo .txt, y un poco en general como hago las peticiones. 

En los servicios tengo el componente objectToFileService, en su implementación indica la ruta donde va a guardar los archivos. Tengo puesta /home/make/ para poder ver el resultado de los archivos, tendrás que poner una donde pueda guardarlo.

Las consultas se accede a través de:
GetMapping /race/{idRace}:
    Guarda en tres archivos la clasificación de la carrera, un archivo por cada categoría.
GetMapping /race/{idRace}/club:
    Guarda en un archivo la clasificación de de la carrera por clubes con sus puntos.
Aunuqe veo que también que puede estar en el dominio de resultado: GetMapping /result/{idRace}, me he decidoo por la opción de ponerlo en carrera.

En runner no contemplo la opción de guardar un corredor sin club, hay que pasarle el la id del club y en el dto se muestra sólo el nombre del club:
    PostMapping/runner/{idClub}:
Para el caso de cambiar de club un corredor también se le pasa la id del club por la url:
    PutMapping/runner/{idRunner}/{idClub}
Aunque veo que también se podría poner el cambio de club de un corredor desde el dominio de club: PutMapping/club/{idClub}/{/idRunner}, me he decidido por la primera opción.
    
En result para añadir un resultado le paso el id de corredor y de carrera y en su dto se muestra el nombre del corredor:
    PostMapping/result/{idrace}/{idrunner}
    
La tabla puntuation tiene DAO y servicio para poder extraer los datos y poder asignar los puntos a cada corredor.


Creo que eso es todo y espero no olvdar nada. Muchas gracias !!