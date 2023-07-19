CREATE TABLE produtos(
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    preco INTEGER NOT NULL,
    qtde INTEGER NOT NULL
);