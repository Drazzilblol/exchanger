CREATE TABLE public.country
(
  id integer NOT NULL DEFAULT nextval('country_id_seq'::regclass),
  name character varying(50),
  country_code character varying(4),
  CONSTRAINT country_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.country
  OWNER TO "Drazz";
