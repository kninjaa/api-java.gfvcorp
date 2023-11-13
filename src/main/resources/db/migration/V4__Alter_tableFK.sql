ALTER TABLE tbVEICULO ADD CONSTRAINT ct_fk_cliente_id
    FOREIGN KEY (ct_int_id) REFERENCES tbCLIENTE (ct_int_id);

ALTER TABLE tbVEICULO ADD CONSTRAINT mc_fk_modelo_str
    FOREIGN KEY (mc_str_modelo) REFERENCES tbMARCA (mc_str_modelo);



ALTER TABLE tbPROTOCOLO ADD CONSTRAINT ct_fk_cliente_id_pro
    FOREIGN KEY (ct_int_id) REFERENCES tbCLIENTE (ct_int_id);

ALTER TABLE tbPROTOCOLO ADD CONSTRAINT ct_fk_veiculo_id_pro
    FOREIGN KEY (vc_int_id) REFERENCES tbVEICULO (vc_int_id);

ALTER TABLE tbPROTOCOLO ADD CONSTRAINT md_fk_modal_str
    FOREIGN KEY (md_str_modal) REFERENCES tbMODAL (md_str_modal);



ALTER TABLE tbMODAL ADD CONSTRAINT mg_fk_tipomodal_str
    FOREIGN KEY (mg_str_tipo) REFERENCES tbTIPOMODALGUINCHO (mg_str_tipo);

ALTER TABLE tbMODAL ADD CONSTRAINT pro_fk_proto_id
    FOREIGN KEY (prot_int_id) REFERENCES tbPROTOCOLO (prot_int_id);

ALTER TABLE tbMODAL ADD CONSTRAINT vc_fk_veiculo_id_md
    FOREIGN KEY (vc_int_id) REFERENCES tbVEICULO (vc_int_id);