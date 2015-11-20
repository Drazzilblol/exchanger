CREATE TABLE public.user_profile
(
  id integer NOT NULL,
  first_name character varying(50),
  last_name character varying(50),
  country_id integer,
  passport_number character varying(50),
  CONSTRAINT user_profile_pkey PRIMARY KEY (id),
  CONSTRAINT user_profile_country_id_fkey FOREIGN KEY (country_id)
      REFERENCES public.country (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_profile_id_fkey FOREIGN KEY (id)
      REFERENCES public.users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.user_profile
  OWNER TO "Drazz";
