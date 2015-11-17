CREATE TABLE public.users
(
  id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
  username character varying(50),
  password character varying(50),
  CONSTRAINT userss_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO "Drazz";