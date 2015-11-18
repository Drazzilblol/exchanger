CREATE TABLE public.currency
(
  id integer NOT NULL DEFAULT nextval('currency_id_seq'::regclass),
  name character varying(50),
  currency_code character varying(10),
  sale double precision,
  buy double precision,
  CONSTRAINT currency_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.currency
  OWNER TO "Drazz";