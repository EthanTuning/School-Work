   M S B A M L   `   `   `  ���� ?  ;Pong, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullclr-namespace:PongPong      Pong.MainWindow   \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     @d2http://schemas.microsoft.com/expression/blend/2008     Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     $localclr-namespace:Pong     -     �Name$  MainWindow1�� � Icon$ icon.png�� � Title$
 Pong��$	��724��$
��1352�� � 
ResizeMode$ NoResize=� � WindowStartupLocation$ CenterScreen=�.��� -    �Name$ Scene��$��0,0,0,-1q�
�������.+�o� -    o�Name$ MainMenu��$��38��$	��Top=�
�������.@�m� -    m�Name$ FileMenu��$
��File��$��35��$��40��$��14(�
�������
�������.@�m� -   $ FileMenuQuitBtn��$
��Quit��m� -   $ GameMenu��$
��Game��$��14(�
�������
�������.@�m� -   $ 
NewMenuBtn��$	��New��.@�m� -   $ _1PlayerMenuBtn��$��1 Player��m� -	   $ _2PlayerMenuBtn��$��2 Player��m� -
   $ ResetMenuBtn��$��Reset��m� -   $ OptionsMenu��$��Options��$��14(�
�������
�������.@�m� -   $ ThemeMenuBtn��$��Theme��.@�m� -   $ DefaultThemeBtn��$��Default��m� -   $ InvertedThemeBtn��$��Inverted��m� -   $ PurpleThemeBtn��$��Purple��m� -   $ BlueThemeBtn��$
��Blue��m� -   $ GreenThemeBtn��$��Green��m� -   $ DifficultyMenuBtn��$��
Difficulty��.@�m� -   $ EasyMenuBtn��$
��Easy��m� -   $ MediumMenuBtn��$��Medium��m� -   $ HardMenuBtn��$
��Hard��m� -   $ HelpMenu��$
��Help��$��14(�
�������
�������.@�m� -   $ AboutMenuBtn��$��About��m� -   $ RulesMenuBtn��$��Rules���� -    ��Name$ 	GameBoard��$��Center=�$	��512��$��0q�$��Center=�$
��1024�����	#FFAEAEAE.+��� -   	 ��Name$	 RightPaddle��
�������$��80��
 �� Left$	
 994��
�������$��20��$��Right=�$��Center=�
 �� Top �� *RightPaddle.Position+�� -   $	 
LeftPaddle��
�������$��80��$
 10��
�������$��20��$
��Left=�$��Center=� �� *LeftPaddle.Position+A� -    A�Name$ GameBall��
�������$��22��
�������$��22�� �� *Ball.Y+
 �� *Ball.X+�� -    ��Name$ 
TitleLabel��$
��Pong��$��Center=�$��610,18,610,0q�$	��Top=�$��48(�$	��126���� -   $ PlayerOneScoreLabel��$��
Player 1: ��$
��Left=�$��
161,48,0,0q�$	��Top=�$	��101��$��22(��� -   $ PlayerTwoScoreLabel��$��
Player 2: ��$
��Left=�$��1033,48,0,0q�$	��Top=�$	��102��$��22(��� -    $ PlayerTwoScore��$
��Left=�$��1140,48,0,0q�$	��Top=�$��45��$��22(����� *Ball.RightScore+�� -!   $ PlayerOneScore��$
��Left=�$��
267,48,0,0q�$	��Top=�$��45��$��22(����� *Ball.LeftScore+