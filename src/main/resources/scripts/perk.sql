CREATE TABLE IF NOT EXISTS perk (
	id SERIAL NOT NULL,
	description VARCHAR(250) NOT NULL,
	is_positive BOOLEAN NOT NULL,
	additional_info VARCHAR(250),
	tier VARCHAR(2),
	recent_performance SMALLINT,
	times_won BIGINT,
	times_lost BIGINT
);

INSERT INTO perk (description, is_positive, additional_info, recent_performance, times_won, times_lost) 
VALUES 
	('Earn U$300 everyday, for one year', TRUE, NULL, 0, 0, 0),
	('Make someone who knows you fall in love with you', TRUE, NULL, 0, 0, 0),
	('Become immortal for 10 days', TRUE, NULL, 0, 0, 0),
	('Become really good at something you have zero knowledge about', TRUE, NULL, 0, 0, 0),
	('Go back to when you were 15 knowing everything you know today', TRUE, NULL, 0, 0, 0),
	('Earn two raises at your job', TRUE, NULL, 0, 0, 0),
	('Earn a promotion at your job', TRUE, NULL, 0, 0, 0),
	('Have sex with someone (it can be anyone in the world), for one week, any time you want', TRUE, NULL, 0, 0, 0),
	('Earn U$10k instantly', TRUE, NULL, 0, 0, 0),
	('Become friends with your idol', TRUE, NULL, 0, 0, 0),
	('Meet your idol', TRUE, NULL, 0, 0, 0),
	('Earn U$50k instantly', TRUE, NULL, 0, 0, 0),
	('Have your next month''s credit card bill paid', TRUE, NULL, 0, 0, 0),
	('Win a all-inclused trip to anywhere in the world for one week', TRUE, NULL, 0, 0, 0),
	('Make someone instantly lose their job', TRUE, NULL, 0, 0, 0),
	('Eat anything you want for free for one month', TRUE, NULL, 0, 0, 0),
	('Three more seasons of your favorite TV series. They''ll be as good as it was before', TRUE, NULL, 0, 0, 0),
	('Become really good at any musical instrument', TRUE, NULL, 0, 0, 0),
	('Earn one year of salary without having to work', TRUE, NULL, 0, 0, 0),
	('You can talk with someone who already died for one day', TRUE, NULL, 0, 0, 0),
	('Die older than 100 years old, if you want', TRUE, NULL, 0, 0, 0),
	('Talk to God, or discover if there is one', TRUE, NULL, 0, 0, 0),
	('You can now talk with your pets', TRUE, NULL, 0, 0, 0),
	('Your child will earn a Nobel at 90 years old', TRUE, NULL, 0, 0, 0),
	('Win an small-sized house/apartment', TRUE, NULL, 0, 0, 0),
	('Have a 50% discount on any car you want', TRUE, NULL, 0, 0, 0),
	('Drug effects last longer and do no harm to your body', TRUE, NULL, 0, 0, 0),
	('Your death will traumatize your entire family', FALSE, NULL, 0, 0, 0),
	('You will die in a vehicle accident (crash or ran over), but you don''t know when', FALSE, NULL, 0, 0, 0),
	('The person you love the most will die in front of you, but you don''t know when', FALSE, 'It will in a accident', 0, 0, 0),
	('You instantly lose your car/house (or the most expensive thing you have) to the government', FALSE, NULL, 0, 0, 0),
	('You instantly lose your car/house to the government', FALSE, 'If you don''t have neighter, it''s the most expensive thing you own', 0, 0, 0),
	('Instantly have a $10k debt', FALSE, NULL, 0, 0, 0),
	('All your SOs will cheat on you one day', FALSE, NULL, 0, 0, 0),
	('Lose your job', FALSE, NULL, 0, 0, 0),
	('Can''t have sex for one year', FALSE, NULL, 0, 0, 0),
	('Feel the worst physical pain you had again', FALSE, NULL, 0, 0, 0),
	('Get shot in the leg', FALSE, 'You won''t die', 0, 0, 0),
	('Have sex with the opposite gender you are attracted to', FALSE, NULL, 0, 0, 0),
	('Drown but get saved in the very last second', FALSE, NULL, 0, 0, 0),
	('Can''t sleep for 3 days', FALSE, NULL, 0, 0, 0),
	('See the year you die', FALSE, NULL, 0, 0, 0),
	('Get convicted to 1 year of prison for a crime you did not commit', FALSE, NULL, 0, 0, 0),
	('Become homeless for one week ', FALSE, 'you can''t sleep at someone''s house', 0, 0, 0),
	('Lose one hand or one foot, you decide', FALSE, NULL, 0, 0, 0),
	('Have your phone stolen and thieves know how to unlock it', FALSE, NULL, 0, 0, 0),
	('Have your incognito search history leaked', FALSE, NULL, 0, 0, 0),
	('Have your high school/college degree revoked', FALSE, NULL, 0, 0, 0),
	('Become unemployed for 3 months', FALSE, NULL, 0, 0, 0),
	('The next plane you take will crash', FALSE, NULL, 0, 0, 0),
	('Become paraplegic for two weeks', FALSE, NULL, 0, 0, 0),
	('Lose one hand', FALSE, NULL, 0, 0, 0),
	('Become blind for one month', FALSE, NULL, 0, 0, 0),
	('Have a EXTREMELY painful headache right after you have sex for the rest of your life', FALSE, NULL, 0, 0, 0),
	('You will sneeze every minute for the rest of your life', FALSE, 'It stops temporarily when you are asleep', 0, 0, 0)