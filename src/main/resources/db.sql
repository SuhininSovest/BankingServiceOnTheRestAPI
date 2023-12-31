PGDMP         9    
            {            test2    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    1486303    test2    DATABASE     y   CREATE DATABASE test2 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE test2;
                postgres    false            �            1259    1492088    account    TABLE     �   CREATE TABLE public.account (
    account_id bigint NOT NULL,
    balance double precision NOT NULL,
    client_id bigint NOT NULL
);
    DROP TABLE public.account;
       public         heap    postgres    false            �            1259    1492087    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    1492093    operation_list    TABLE       CREATE TABLE public.operation_list (
    operation_id bigint NOT NULL,
    account_id bigint NOT NULL,
    amount double precision NOT NULL,
    client_id bigint NOT NULL,
    operation_date timestamp without time zone,
    operation_type smallint NOT NULL
);
 "   DROP TABLE public.operation_list;
       public         heap    postgres    false            �          0    1492088    account 
   TABLE DATA           A   COPY public.account (account_id, balance, client_id) FROM stdin;
    public          postgres    false    215   :       �          0    1492093    operation_list 
   TABLE DATA           u   COPY public.operation_list (operation_id, account_id, amount, client_id, operation_date, operation_type) FROM stdin;
    public          postgres    false    216   i                  0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 11, true);
          public          postgres    false    214            j           2606    1492092    account account_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public            postgres    false    215            l           2606    1492097 "   operation_list operation_list_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.operation_list
    ADD CONSTRAINT operation_list_pkey PRIMARY KEY (operation_id);
 L   ALTER TABLE ONLY public.operation_list DROP CONSTRAINT operation_list_pkey;
       public            postgres    false    216            m           2606    1492098 *   operation_list fk4bivca1tk64bclp8ns4br3ry3    FK CONSTRAINT     �   ALTER TABLE ONLY public.operation_list
    ADD CONSTRAINT fk4bivca1tk64bclp8ns4br3ry3 FOREIGN KEY (account_id) REFERENCES public.account(account_id);
 T   ALTER TABLE ONLY public.operation_list DROP CONSTRAINT fk4bivca1tk64bclp8ns4br3ry3;
       public          postgres    false    215    3178    216            �      x�3�4420�3�4�2�443�b���� :g�      �   o   x�}���0D�3UE01�dQ���:�0ׄ���|#!�P���%؆-�}��s8i�B��h�B��Q�Q�����eW�`��ܺRA�e��"S���c��:�     