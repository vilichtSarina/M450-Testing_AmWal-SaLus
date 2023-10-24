--ROLES
-- INSERT INTO role(id, name)
-- VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
--        ('ab505c92-7280-49fd-a7de-258e618df074', 'PRIVILEGED') ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
       ('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'PRIVILEGED')
    ON CONFLICT DO NOTHING;

-- --assign authorities to roles
-- INSERT INTO role_authority(role_id, authority_id)
-- VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', '2ebf301e-6c61-4076-98e3-2a38b31daf86'),
--        ('ab505c92-7280-49fd-a7de-258e618df074', '2ebf301e-6c61-4076-98e3-2a38b31daf86'),
--        ('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868')
--     ON CONFLICT DO NOTHING;