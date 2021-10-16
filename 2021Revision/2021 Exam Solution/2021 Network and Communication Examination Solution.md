# 2021 Network and Communication Examination Solution

*Disclaimer: this solution only serves as a reference. Some answer may be incorrect or insufficient. If you think something is wrong just send me a message or leave a comment :)*

1. a. i) http://192.168.1.1 (Notice that using `https` might be incorrect here because some routers just don't go with `https://`)

   ​	ii) Network --> Firewall --> Port Forwarding (There is no right answer for this one. This example comes from OpenWRT system on my Raspberry Pi).

   ​	iii) I will probably open port 8080 for this purpose because this port is not used or occupied by the router OS (e.g. ssh, telnet, http/https). I will not choose a very high port (e.g. 5-digit port) because ports with higher numbers might be used by other user programs and will likely clash with them.

   ​	iv) I will also need to open this port on my local computer, assuming we are using port forwarding to direct packets to my local computer via my router.

   b. The closest distance betweem Mars and Earth is $5.46\times 10^7$ kilometres. The calculation is shown below
   $$
   \#\text{total time of transmission}=69\text{ minutes}\cdot 60\ \frac{\text{seconds}}{\text{minutes}}+42\text{ seconds}=4182\text{ seconds}\\
   \#\text{time used to trasmit 1GB data}=\frac{1\times 10^9\times 8\text{ bit}}{2\times 10^6\text{bit/s}}=4000\text{ seconds}\\
   \#\text{closest distance btw Mars & Earth}=3\times 10^8\text{ m/s}\times (4182-4000)\text{ seconds}=5.46\times 10^7\text{ km}
   $$
   c. In the interaction over the imaginary protocol, the first line is a command trying to connect to the server whose domain name is `example.edu`. The next line and all the `#MKAY` are responses from the server, possibly meaning `OK` or `done`. `PORT 12345` command tries to connect to the server using port 12345. The remote server then acknowldges with a reponse of `#MKAY PORT SET TO 12345`. The `GIEF` command tries to download the file located in `/path/to/file.txt` on the server. The server then responds with several lines of acknowledgements of `#MKAY`. Finally, we end the connection by `KTHXBAI` command and the server responds with an acknowledgement of disconnection.

   d. During the transfer, DATA will be segmented as follows

   ```
   After 1 RTT : A
   After 2 RTT : BC
   After 3 RTT : DEF
   After 4 RTT : G
   ```

   ​	assuming that the TCP congestion protocol will always round up the windows size during calculation. The calculation is shown below

   ```
   Rounds of transfer per RTT
   1 W=MSS=1B, using slow start. Segment is A
   2 W=2*W=2B, using congestion avoidance. Segment is BC
   3 W=W+MSS^2/W=2+1/2=3, using congestion avoidance. Segment is DEF
   4 W=W+MSS^2/W=3+1/3=4, using congestion avoidance. Segment is G
   ```

   e. i) Allow		ii) 49152 - 65535		iii) Allow		iv) 20, 21

   ​	v) TCP		  vi) 49152 - 65535	   vii) TCP

   ​	viii) Enable SMTP/POP3 server access

   ​	ix) Allow	  x) 49152 - 65535		xi) 53			 xii) Deny

   ​	assuming that we do not allow connections other than the ones listed in the Access Control List. In other words, we assume that this is a white list.

2. As soon as Router D disappears, all relevant distance routing information of each router regarding connection with Router D will be updated according to the information helf by neighbour routers:

   ```
   RouterA = {(A, B, 3), (A, C, 4), (A, D, 11)}
   
   Router A ask Router D with failed response, so it asks neighbour Router C for the distance between C and D
   
   RouterB = {(B, A, 3), (B, C, 5), (B, E, 7)}
   
   Router D is not involed in Router B's table so no changes made
   
   RouterC = {(C, A, 4), (C, B, 5), (C, D, 15)}
   
   Router C asks Router D, which will fail, so it then asks neighbours for the shortest distance to D
   
   RouterD = {undefined}
   
   Since Router D has been down, the routing table is unavailable
   
   RouterE = {(E, B, 7), (E, D, ∞)}
   
   Since D does not respond, Router E asks its only neighbour B about D. However, Router B does not directly connect to D, so the distance of E to D remains unknown until the next iteration of distance vector routing.
   ```

   b. The master virus process, which migh has admin permission level in the operating system, is listening to `localhost` on port 25. It is waiting for the slave virus processes to connect. The three slave virus processes with low permission level can increase their permission level to admin by communicating with the master virus process via TCP port 25. In fact, one of them has already established such connection.

   c. i) ARP spoofing. The message serves as an ARP response that tries to make the hosts in the network believe the given IP address is associated with the attacker's machine MAC address. This will result in packets with destination IP `10.0.1.2` directed to the attacker's machine where in fact they should have been sent to a legitimate host with this IP address.

   ​	ii) We can move `Server 0` to a different subnet by making it connect to `Router 0` instead of `Switch 0`

   ​	iii) We can replace `Hub 0` with a switch

   d. i) Ethernet cables (e.g. Cat5e). They can optionally purchase optical fiber for faster connection.

   ​	ii) They should purchase Wireless Access Point in order for their mobile device to connect to the network. They also need switches in order to connect their devices using wire within the same subnet. (e.g. they might need a switch to connect up servers, desktops, and WAP) They also need a router in the server room to connect local ISP network to the company LAN.

   e. i) 1⃣️ The BGP protocol is an inter-AS routing protocol, rather than intra-AS as described in the ad.

   ​		2⃣️ The word "statelike" should be "stateless"

   ​		3⃣️ SHA is a hash function, not an encryption algorithm

   ​		4⃣️ QUIC was invented by Google in 2012, which has not lasted for 10+ years yet

   ​	ii) This role might be a Network Security Engineer role where the main job is to make system and data secure by employing firewall and encryptions. It also provides optimisation of TCP/UDP connections to speed up application connection. It might also involve design routing system to communicate within/between autononous systems.

   ​	   