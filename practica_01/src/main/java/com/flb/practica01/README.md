Desarrollo Web Back-End
=======================

Práctica 01
-----------

Para crear la base de datos:
```
$ sudo -u postgres psql
```
Luego crear la base de datos con propietario *cus_reg*:
```
DROP DATABASE IF EXISTS customer_region;

DROP USER IF EXISTS cus_reg;

CREATE USER cus_reg WITH PASSWORD 'cus_reg';

CREATE DATABASE customer_region WITH OWNER cus_reg;
```

Ingresar a la base:
```
$ psql customer_region
```

Y crear las tablas
```
CREATE TABLE region (
    region_id INT UNIQUE NOT NULL,
    region VARCHAR(20),
    CONSTRAINT pk_region PRIMARY KEY(
	region_id
    )
);

CREATE TABLE customer (
    customer_id INT UNIQUE NOT NULL,
    name VARCHAR(25) NOT NULL,
    surname VARCHAR(25) NOT NULL,
    rfc VARCHAR(13) UNIQUE NOT NULL,
    mail VARCHAR(50) UNIQUE NOT NULL,
    region INT NOT NULL
    REFERENCES region(
	region_id
    ),
    CONSTRAINT pk_customer PRIMARY KEY(
	customer_id
    )
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO cus_reg;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO cus_reg;
```

Y poblar la base con el archivo *customer_regionDML.sql*.
