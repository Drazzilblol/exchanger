CREATE TABLE public.operation
(
  id integer NOT NULL DEFAULT nextval('operation_id_seq'::regclass),
  currency_from_id integer,
  currency_to_id integer,
  account_from_id integer,
  account_to_id integer,
  date date,
  currency_sell double precision,
  currency_buy double precision,
  CONSTRAINT operation_pkey PRIMARY KEY (id),
  CONSTRAINT operation_account_from_id_fkey FOREIGN KEY (account_from_id)
      REFERENCES public.account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT operation_account_to_id_fkey FOREIGN KEY (account_to_id)
      REFERENCES public.account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT operation_currency_from_id_fkey FOREIGN KEY (currency_from_id)
      REFERENCES public.currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT operation_currency_to_id_fkey FOREIGN KEY (currency_to_id)
      REFERENCES public.currency (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.operation
  OWNER TO "Drazz";