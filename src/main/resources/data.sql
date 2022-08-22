delete from Item_Ref;
delete from Robot;
delete from Robot_Order;
delete from Item;

insert into Item (id, name, type)
values ('SBB', 'Square box', 'BODY'),
       ('CB', 'Cylinder', 'BODY'),
       ('CPUBT', 'Baical Titan', 'CONTROLLER'),
       ('CPUP', 'Intel Pentium', 'CONTROLLER'),
       ('TC', 'Trucks', 'CHASSIS'),
       ('WC', 'Wheels', 'CHASSIS'),
       ('AM', 'Arm', 'MANIPULATOR'),
       ('TAM', 'Telescopic arm', 'MANIPULATOR'),
       ('NPS', 'Nuclear power supply', 'POWER_SOURCE'),
       ('ZCB', 'Zinc-carbon battery', 'POWER_SOURCE');