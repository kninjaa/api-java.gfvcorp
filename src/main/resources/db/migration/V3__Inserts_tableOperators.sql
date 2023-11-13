INSERT INTO tbTIPOMODALGUINCHO (mg_str_tipo)
    VALUES ('Leve');
INSERT INTO tbTIPOMODALGUINCHO (mg_str_tipo)
    VALUES ('Pesado');
INSERT INTO tbTIPOMODALGUINCHO (mg_str_tipo)
    VALUES ('Especializado');


-- Insert de modelos de caminhões, previa
INSERT INTO tbMARCA (mc_int_identificador, mc_str_marca, mc_str_modelo)
  SELECT 1000, 'Volvo', 'VNL 780' FROM dual
    UNION ALL SELECT 1000, 'Volvo', 'FH 540' FROM dual
    UNION ALL SELECT 1000, 'Volvo', 'FM 460' FROM dual
    UNION ALL SELECT 1000, 'Volvo', 'FL 240' FROM dual
    UNION ALL SELECT 1000, 'Volvo', 'VNM 360' FROM dual

    UNION ALL SELECT 2000, 'DAF', 'XF' FROM dual
    UNION ALL SELECT 2000, 'DAF', 'CF' FROM dual
    UNION ALL SELECT 2000, 'DAF', 'LF' FROM dual
    UNION ALL SELECT 2000, 'DAF', 'XF Space Cab' FROM dual
    UNION ALL SELECT 2000, 'DAF', 'CF Space Cab' FROM dual

    UNION ALL SELECT 3000, 'Volkswagen', 'MAN TGX' FROM dual
    UNION ALL SELECT 3000, 'Volkswagen', 'MAN TGS' FROM dual
    UNION ALL SELECT 3000, 'Volkswagen', 'Constellation' FROM dual
    UNION ALL SELECT 3000, 'Volkswagen', 'Delivery' FROM dual
    UNION ALL SELECT 3000, 'Volkswagen', 'MAN TGM' FROM dual

    UNION ALL SELECT 4000, 'Scania', 'R 450' FROM dual
    UNION ALL SELECT 4000, 'Scania', 'G 410' FROM dual
    UNION ALL SELECT 4000, 'Scania', 'P 340' FROM dual
    UNION ALL SELECT 4000, 'Scania', 'S 540' FROM dual
    UNION ALL SELECT 4000, 'Scania', 'R 580' FROM dual

    UNION ALL SELECT 5000, 'Mercedes-Benz', 'Axor 3131' FROM dual
    UNION ALL SELECT 5000, 'Mercedes-Benz', 'Atego 2726' FROM dual
    UNION ALL SELECT 5000, 'Mercedes-Benz', 'Actros 4144' FROM dual
    UNION ALL SELECT 5000, 'Mercedes-Benz', 'Axor 2526' FROM dual
    UNION ALL SELECT 5000, 'Mercedes-Benz', 'Axor 3344' FROM dual

    UNION ALL SELECT 6000, 'Iveco', 'Stralis 450' FROM dual
    UNION ALL SELECT 6000, 'Iveco', 'Daily 35S14' FROM dual
    UNION ALL SELECT 6000, 'Iveco', 'Eurocargo Tector 240' FROM dual
    UNION ALL SELECT 6000, 'Iveco', 'Hi-Way 570' FROM dual
    UNION ALL SELECT 6000, 'Iveco', 'Stralis 570' FROM dual;