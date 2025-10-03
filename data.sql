-- Insertion des utilisateurs
INSERT INTO utilisateur (nom, email, mdp) VALUES
('Alice', 'alice@example.com', 'password1'),
('Bob', 'bob@example.com', 'password2'),
('Charlie', 'charlie@example.com', 'password3'),
('Diana', 'diana@example.com', 'password4');

-- Insertion des types de conversation
INSERT INTO type_conversation (libelle) VALUES
('prive'),
('groupe');

-- Insertion des conversations privées
INSERT INTO conversation (nom, id_type) VALUES
('Alice-Bob', 1),
('Alice-Charlie', 1),
('Alice-Diana', 1),
('Bob-Charlie', 1),
('Bob-Diana', 1),
('Charlie-Diana', 1);

-- Insertion de la conversation de groupe
INSERT INTO conversation (nom, id_type) VALUES
('Groupe-Alice-Bob-Charlie', 2);

-- Association des utilisateurs aux conversations privées
INSERT INTO user_conversation (id_user, id_conversation) VALUES
(1, 1), (2, 1), -- Alice-Bob
(1, 2), (3, 2), -- Alice-Charlie
(1, 3), (4, 3), -- Alice-Diana
(2, 4), (3, 4), -- Bob-Charlie
(2, 5), (4, 5), -- Bob-Diana
(3, 6), (4, 6); -- Charlie-Diana

-- Association des utilisateurs à la conversation de groupe
INSERT INTO user_conversation (id_user, id_conversation) VALUES
(1, 7), (2, 7), (3, 7); -- Groupe-Alice-Bob-Charlie

-- Insertion des messages pour chaque conversation
-- 6 messages par utilisateur par conversation
INSERT INTO message (contenu, id_user, id_conversation) VALUES
-- Messages pour Alice-Bob
('Salut Bob, comment ça va ?', 1, 1),
('Salut Alice, ça va bien et toi ?', 2, 1),
('Je vais bien, merci !', 1, 1),
('Tu travailles sur quoi en ce moment ?', 2, 1),
('Je travaille sur un projet SQL.', 1, 1),
('Super, bon courage !', 2, 1),

-- Messages pour Alice-Charlie
('Salut Charlie, quoi de neuf ?', 1, 2),
('Salut Alice, pas grand-chose.', 3, 2),
('Tu as vu le dernier film ?', 1, 2),
('Oui, c’était génial !', 3, 2),
('Je suis d’accord.', 1, 2),
('On en reparlera bientôt.', 3, 2),

-- Messages pour Alice-Diana
('Salut Diana, ça fait longtemps !', 1, 3),
('Salut Alice, oui c’est vrai.', 4, 3),
('On devrait se voir bientôt.', 1, 3),
('Avec plaisir !', 4, 3),
('Je te tiens au courant.', 1, 3),
('D’accord, à bientôt.', 4, 3),

-- Messages pour Bob-Charlie
('Salut Charlie, ça va ?', 2, 4),
('Salut Bob, ça va bien.', 3, 4),
('Tu travailles sur quoi ?', 2, 4),
('Un projet de développement.', 3, 4),
('Intéressant, bon courage !', 2, 4),
('Merci, toi aussi.', 3, 4),

-- Messages pour Bob-Diana
('Salut Diana, quoi de neuf ?', 2, 5),
('Salut Bob, pas grand-chose.', 4, 5),
('Tu as des projets en cours ?', 2, 5),
('Oui, un projet de design.', 4, 5),
('Super, bon courage !', 2, 5),
('Merci, toi aussi.', 4, 5),

-- Messages pour Charlie-Diana
('Salut Diana, comment ça va ?', 3, 6),
('Salut Charlie, ça va bien.', 4, 6),
('Tu fais quoi en ce moment ?', 3, 6),
('Je travaille sur un projet.', 4, 6),
('Bon courage pour ton projet.', 3, 6),
('Merci, toi aussi.', 4, 6),

-- Messages pour la conversation de groupe
('Salut tout le monde !', 1, 7),
('Salut Alice !', 2, 7),
('Salut Alice et Bob !', 3, 7),
('Comment ça va ?', 1, 7),
('Ça va bien, merci.', 2, 7),
('Pareil ici.', 3, 7);