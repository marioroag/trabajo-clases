### Modelo racional:

SOCIOS (**idSocio**, nombre, direccion, telefono)
LIBROS (**idLibro**, titulo, autor, anio_publicacion)
CATEGORIAS (**idCategoria**, nombre)
LIBRO_TIENE_CATEGORIA (**idLibro**, **FK: idCategoria**)
PRESTAMOS (**idPrestamo**, fecha_inicio, fecha_devolucion, **FK: idSocio**)