-- Table des utilisateurs
CREATE TABLE utilisateur (
   id_user SERIAL PRIMARY KEY,
   nom VARCHAR(50) NOT NULL,
   email VARCHAR(50) UNIQUE NOT NULL,
   mdp VARCHAR(255) NOT NULL
);

-- Table des types de conversation (prive, groupe, etc.)
CREATE TABLE type_conversation (
   id_type SERIAL PRIMARY KEY,
   libelle VARCHAR(20) NOT NULL
);

-- Table des conversations
CREATE TABLE conversation (
   id_conversation SERIAL PRIMARY KEY,
   nom VARCHAR(50),
   date_creation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   id_type INT NOT NULL,
   FOREIGN KEY(id_type) REFERENCES type_conversation(id_type)
);

-- Table des messages
CREATE TABLE message (
   id_message SERIAL PRIMARY KEY,
   contenu TEXT NOT NULL,
   date_envoi TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   est_lu BOOLEAN NOT NULL DEFAULT FALSE,
   id_user INT NOT NULL,
   id_conversation INT NOT NULL,
   FOREIGN KEY(id_user) REFERENCES utilisateur(id_user) ON DELETE CASCADE,
   FOREIGN KEY(id_conversation) REFERENCES conversation(id_conversation) ON DELETE CASCADE
);

CREATE TABLE user_conversation (
   id_user INT NOT NULL,
   id_conversation INT NOT NULL,
   date_entree TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(id_user, id_conversation),
   FOREIGN KEY(id_user) REFERENCES utilisateur(id_user) ON DELETE CASCADE,
   FOREIGN KEY(id_conversation) REFERENCES conversation(id_conversation) ON DELETE CASCADE
);
