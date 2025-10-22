# Enunciado: Sistema de Gestión de una Bolera

Una bolera necesita un sistema para gestionar sus pistas, clientes, reservas y empleados. A continuación se describen los elementos del sistema:

1. **Clientes**: Cada cliente tiene un número de identificación único, nombre, dirección y teléfono.
2. **Pistas**: Cada pista tiene un número de pista único, capacidad máxima y estado (disponible, ocupada, en mantenimiento).
3. **Reservas**: Cada reserva tiene un código único, fecha y hora de la reserva, y duración. Un cliente puede reservar varias pistas en diferentes momentos.
4. **Empleados**: Cada empleado tiene un número de identificación único, nombre, puesto y fecha de contratación. Los empleados se encargan del mantenimiento y la gestión de las pistas.
5. **Pagos**: Cada pago tiene un número único, monto, fecha del pago, y método de pago. Un pago corresponde a una reserva hecha por un cliente.
6. **Promociones**: La bolera ofrece promociones. Cada promoción tiene un código único, nombre, descripción, y porcentaje de descuento. Un cliente puede disfrutar de varias promociones a lo largo del tiempo.

## Relaciones

- Cada cliente puede hacer varias reservas en la bolera, y cada reserva está asociada a una pista específica.
- Los empleados se encargan del mantenimiento de las pistas.
- Un cliente puede realizar varios pagos, y cada pago corresponde a una reserva específica.
- Un cliente puede disfrutar de múltiples promociones, y una promoción puede ser aprovechada por varios clientes.

## Tareas

1. Realiza el Diagrama Entidad-Relación (ER) para representar el sistema de gestión de la bolera.
2. A partir del Diagrama ER, transforma el diseño en un modelo relacional.
