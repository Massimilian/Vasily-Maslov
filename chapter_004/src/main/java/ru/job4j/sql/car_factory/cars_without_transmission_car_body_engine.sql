select car.name, transmission.name, car_body.name, engine.name from car 
right outer join transmission on car.transmission_id=transmission.id
right outer join car_body on car.car_body_id=car_body.id
right outer join engine on car.engine_id=engine.id where car is null;
