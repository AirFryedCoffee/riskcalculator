In this project, I created a small desktop app using Java. I am implementing this by using a JFrame provided by the javax.swing package. 
I also implemented an Action Listener to verify certain parameters were met. 

When I used to trade stocks I used to calculate the risk that I would take on each trade. Some trades were only worth 0.5% of my account, other trades had 
higher odds and they were worth 2-3 % of my account. The point of this application is to calculate the number of shares that a user should purchase of a certain stock, 
determined by the input the user has passed in. 

For example: 
If a user has an account with exactly 100,000$, and for simplicity's sake, the user wants to buy $AAPL at 150.00, with a stop loss at 149.00. The user will then be 
asked what % of the account the user would like to risk. Let's say the user selects 2.5% of their account to risk. This would mean they will not lose more than 2,500$ 
on this trade. The calculator will then determine based on how much the stock and the stop loss are, how many shares the user should purchase, with exactly 1$ of risk 
(150 or share price, - 149 or stop loss price)


