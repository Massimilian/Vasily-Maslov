select car.name, transmission.name, car_body.name, engine.name from car 
left outer join transmission on car.transmission_id=transmission.id 
left outer join car_body on car.car_body_id=car_body.id
left outer join engine on car.engine_id=engine.id;