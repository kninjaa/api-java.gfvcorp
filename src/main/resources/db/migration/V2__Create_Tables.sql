CREATE TABLE tbMARCA(
    mc_int_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    mc_int_identificador INTEGER NOT NULL,
    mc_str_marca VARCHAR2(255) NOT NULL,
    mc_str_modelo VARCHAR2(255) UNIQUE NOT NULL
);

CREATE TABLE tbTIPOMODALGUINCHO (
    mg_int_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    mg_str_tipo VARCHAR2(255) UNIQUE NOT NULL
);

CREATE TABLE tbCLIENTE (
    ct_int_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ct_bool_situacao VARCHAR2(8) NOT NULL,
    ct_str_name VARCHAR2(255) NOT NULL,
    ct_str_cpf VARCHAR2(11) UNIQUE NOT NULL,
    ct_str_cnh VARCHAR2(12) UNIQUE NOT NULL,
    ct_str_email VARCHAR2(255) UNIQUE NOT NULL,
    ct_str_pass VARCHAR2(500) NOT NULL
);

CREATE TABLE tbVEICULO (
    vc_int_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ct_int_id INTEGER NOT NULL,
    vc_str_placa VARCHAR2(255) UNIQUE NOT NULL,
    mc_str_modelo VARCHAR2(255) NOT NULL,
    vc_bool_mod VARCHAR2(15) NOT NULL,
    vc_str_tamanho VARCHAR2(255) NOT NULL,
    vc_int_peso FLOAT NOT NULL,
    vc_int_qtdeix NUMBER NOT NULL,
    vc_bool_blindagem VARCHAR2(15) NOT NULL,
    vc_bool_carga VARCHAR2(15) NOT NULL
);

CREATE TABLE tbPROTOCOLO (
    prot_int_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    prot_str_protocolo VARCHAR2(150) UNIQUE NOT NULL,
    prot_dat_datAcionada DATE NOT NULL,
    ct_int_id INTEGER NOT NULL,
    vc_int_id INTEGER NOT NULL,
    md_str_modal VARCHAR2(255)
);

CREATE TABLE tbMODAL (
    md_int_id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    md_str_modal VARCHAR2(255) UNIQUE NOT NULL,
    md_str_loc VARCHAR2(255) NOT NULL,
    mg_str_tipo VARCHAR2(255) NOT NULL,
    prot_int_id INTEGER NOT NULL,
    vc_int_id INTEGER NOT NULL                     
);
