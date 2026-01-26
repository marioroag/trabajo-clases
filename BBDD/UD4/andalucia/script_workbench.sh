sudo mysql -u root < config_usuario.sql

sudo mysql -u root < Ej1.sql
sudo mysql -u root < Ej2.sql
sudo mysql -u root < Ej3.sql
sudo mysql -u root < Ej4.sql

sudo cp andalucia.csv /var/lib/mysql-files/data_andalucia.csv

sudo mysql -u root < Peliculas.sql
sudo mysql -u root < SemanaSanta.sql

sudo mysql -u root < ordenes.sql