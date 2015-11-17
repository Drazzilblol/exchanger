CREATE TABLE public.account
(
  id integer NOT NULL DEFAULT nextval('account_id_seq'::regclass),
  value real,
  currency_id integer,
  user_id integer,
  name character varying(50),
  CONSTRAINT account_pkey PRIMARY KEY (id),
  CONSTRAINT account_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES public.customers (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.account
  OWNER TO postgres;