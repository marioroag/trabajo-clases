### Modelo racional:

SOCIOS (PK: idSocio, nombre, direccion, telefono)
LIBROS (PK: idLibro, titulo, autor, anio_publicacion)
CATEGORIAS (PK: idCategoria, nombre)
LIBRO_TIENE_CATEGORIA (idLibro, idCategoria)
PRESTAMOS (PK: idPrestamo, idSocio, fecha_inicio, fecha_devolucion)
