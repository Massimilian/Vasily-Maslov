select car.name, transmission.name from car 
right outer join transmission on car.transmission_id=transmission.id where car is null;
