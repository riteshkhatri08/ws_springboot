--  INgredient table
create table if not exists Ingredient (
  id varchar(4) not null ,
  name varchar(25) not null,
  type varchar(10) not null,
  PRIMARY KEY (id) 
);

-- TACO_ORDER TABLE
create table if not exists Taco_Order (
  id identity,
  delivery_Name varchar(50) not null,
  delivery_Street varchar(50) not null,
  delivery_City varchar(50) not null,
  delivery_State varchar(20) not null,
  delivery_Zip varchar(10) not null,
  cc_number varchar(16) not null,
  cc_expiration varchar(5) not null,
  cc_cvv varchar(3) not null,
  placed_at timestamp not null
);

-- TACO Table
create table if not exists Taco (
  id identity,
  name varchar(50) not null,
  taco_order bigint not null,
  taco_order_key bigint not null,
  created_at timestamp not null
);

--  Ingredient ref table 
create table if not exists Ingredient_Ref (
  ingredient varchar(4) not null ,
  taco bigint not null,
  taco_key bigint not null
);

-- Link Taco and Ingredient table
alter table
  Taco
add
  foreign key (taco_order) references Taco_Order(id);

-- link ingredient ref and ingredient id  
alter table
  Ingredient_Ref
add
  foreign key (ingredient) references Ingredient(id);

/*
 
 Relationship b/w above 4 tables 
 
 TACO_ORDER --------* TACO ----------* INGGREDIENT_REF *------------ INGREDIENTS
 
 */