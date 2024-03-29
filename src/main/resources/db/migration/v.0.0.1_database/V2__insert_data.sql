-- USERS
insert into users (id, username, firstname, surname, email, password)
values ('c23ebbb0-4d47-42b3-982b-0b963d917a25', 'milton.pfeffer', 'Milton', 'Pfeffer', 'milton.pfeffer@yahoo.com',
        '$2a$10$7vqEc2dA.HYfLr9YSQFv1uPn89zb43HgyR9DYmoq0uCDVeM9cOGqq'),
       ('7dc91392-0dce-45e8-b3a8-c4e711b2f45f', 'gerald.hyatt', 'Gerald', 'Hyatt', 'gerald.hyatt@yahoo.com',
        '$2a$10$3Lr3sp3OcUEErzSjwtezaeW16OsK83./6JrN66qexpbgGIIJF8mEO'),
       ('14b75de4-c006-445a-b131-7ffa477d7665', 'avery.pfeffer', 'Avery', 'Pfeffer', 'avery.pfeffer@yahoo.com',
        '$2a$10$hEy85MmWmo1rKR.IHS36y.qYQgFIMqrcWY26lQegqlFdvge7RLmjO'),
       ('96993edc-7ccc-46f4-90ba-926930be623d', 'travis.mohr', 'Travis', 'Mohr', 'travis.mohr@gmail.com',
        '$2a$10$B0aU1Jcyq7BmGFyVW/Z3G.GaVYjBj3Ua8.5xPkK8eMuLHdq8De0WO'),
       ('e3ea02ff-2e76-49be-8598-18f2495a8946', 'gabriel.okeefe', 'Gabriel', 'Okeefe', 'gabriel.okeefe@gmail.com',
        '$2a$10$ZEXr.8MjeRqPoYrFFGuf7ugSuHaFRybg4wW8k/DiMUOS/p7pMklIe'),
       ('7e2e9be8-e0e1-4ed3-981c-499cf04d2066', 'porfirio.kris', 'Kris', 'Porfirio', 'porfirio.kris@yahoo.com',
        '$2a$10$3Lr3sp3OcUEErzSjwtezaeW16OsK83./6JrN66qexpbgGIIJF8mEO');

-- PROJECTS
insert into projects (id, creator_id, name, description)
values ('34c5773b-0a9b-40c3-988e-e8f3a530c8c5', 'e3ea02ff-2e76-49be-8598-18f2495a8946', 'Walsh-Pfeffer',
        'Tempora possimus ab ut voluptates aspernatur repellendus voluptatem deleniti quaerat ipsam.'),
       ('8ec8eaf0-b1de-4f4b-8715-64b2959bffd2', '14b75de4-c006-445a-b131-7ffa477d7665', 'Deckow-Johnson',
        'Hic ratione blanditiis rerum distinctio ea sed tenetur illo ab dolor eaque.');

-- USER_PROJECT
insert into user_projects (user_id, project_id)
values ('c23ebbb0-4d47-42b3-982b-0b963d917a25', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5'),
       ('7dc91392-0dce-45e8-b3a8-c4e711b2f45f', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5'),
       ('c23ebbb0-4d47-42b3-982b-0b963d917a25', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5'),
       ('14b75de4-c006-445a-b131-7ffa477d7665', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5'),
       ('7dc91392-0dce-45e8-b3a8-c4e711b2f45f', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5'),
       ('14b75de4-c006-445a-b131-7ffa477d7665', '8ec8eaf0-b1de-4f4b-8715-64b2959bffd2'),
       ('e3ea02ff-2e76-49be-8598-18f2495a8946', '8ec8eaf0-b1de-4f4b-8715-64b2959bffd2'),
       ('96993edc-7ccc-46f4-90ba-926930be623d', '8ec8eaf0-b1de-4f4b-8715-64b2959bffd2');

-- TASKS
INSERT INTO tasks (id, project_id, assigned_to, created_by, title, description, status, due_to)
VALUES ('86036cd8-4fbc-4dab-8f74-ec4cc82df6a4', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5',
        '7dc91392-0dce-45e8-b3a8-c4e711b2f45f', '14b75de4-c006-445a-b131-7ffa477d7665',
        'Sed aperiam in itaque blanditiis optio.',
        'Eum aut laudantium hic architecto est ratione perspiciatis in omnis autem commodi.', 'TODO',
        '2024-04-01'),
       ('fd9e86b6-b89d-42bf-badf-610c3ccd7bb2', '8ec8eaf0-b1de-4f4b-8715-64b2959bffd2',
        '96993edc-7ccc-46f4-90ba-926930be623d', '96993edc-7ccc-46f4-90ba-926930be623d', 'Molestiae et laudantium.',
        'Enim est voluptatum accusamus ut ratione culpa totam reiciendis et.', 'REJECTED', '2024-10-09'),
       ('bcb89d6c-edbf-49fc-83e0-cb104dfe76b3', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5',
        '7dc91392-0dce-45e8-b3a8-c4e711b2f45f', 'c23ebbb0-4d47-42b3-982b-0b963d917a25', 'Est laborum voluptatem quis.',
        'Assumenda praesentium iste sit sit veniam itaque.', 'IN_PROGRESS', '2024-02-08'),
       ('51563fe9-4510-405e-9eaf-b3a573e860b5', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5',
        'c23ebbb0-4d47-42b3-982b-0b963d917a25', 'c23ebbb0-4d47-42b3-982b-0b963d917a25', 'Fuga minima sunt est dolores.',
        'Facilis eos mollitia est enim praesentium totam est assumenda expedita harum sed.', 'REVIEW',
        '2024-02-05'),
       ('7171064d-2d76-4b37-9278-6edebcb141b2', '8ec8eaf0-b1de-4f4b-8715-64b2959bffd2',
        'e3ea02ff-2e76-49be-8598-18f2495a8946', '14b75de4-c006-445a-b131-7ffa477d7665',
        'Asperiores quasi porro vel in.',
        'Velit nisi incidunt voluptatem unde est tempora doloremque natus facere id molestiae.', 'TODO',
        '2024-05-12'),
       ('cb53e7b0-9148-46b2-b1a3-1ea3597ac843', '8ec8eaf0-b1de-4f4b-8715-64b2959bffd2',
        '14b75de4-c006-445a-b131-7ffa477d7665', '7dc91392-0dce-45e8-b3a8-c4e711b2f45f', 'Maiores qui nihil.',
        'Dolorum qui fuga eius necessitatibus eligendi aut exercitationem fugit omnis dolorem.', 'REVIEW',
        '2024-12-11'),
       ('2aef2860-fb63-423f-838f-074fe061656a', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5',
        '14b75de4-c006-445a-b131-7ffa477d7665', '14b75de4-c006-445a-b131-7ffa477d7665', 'Sunt nihil ipsam et quo ab.',
        'Iste quaerat iste aut eligendi dicta eveniet perferendis.', 'CANCELLED', '2024-01-23'),
       ('e9e6f136-3df3-4c4a-a935-d3727c096bfe', '34c5773b-0a9b-40c3-988e-e8f3a530c8c5',
        '7dc91392-0dce-45e8-b3a8-c4e711b2f45f', 'e3ea02ff-2e76-49be-8598-18f2495a8946',
        'Mollitia consequatur provident.', 'Corrupti iure minus fugit eum eos enim quam.', 'TODO',
        '2024-03-21');

-- MESSAGES
INSERT INTO notifications(id, sender, receiver, message)
VALUES ('2d7e620a-8a3e-4d2e-b4de-a61126ab3b67', 'c23ebbb0-4d47-42b3-982b-0b963d917a25',
        '7dc91392-0dce-45e8-b3a8-c4e711b2f45f', 'hellooooooO!')