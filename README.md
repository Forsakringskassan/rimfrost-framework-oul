# rimfrost-framework-oul
Ramverkskomponent för hantering av Operativt uppgiftslager

Innehåller consumer/producer för för klienter som skapar nya operativa uppgifter.
Skapad för att underlätta för implementation av manuella regler att integrera med operativt-uppgifts-lager.

_integration/kafka_ innehåller DTO för message request som skickas till OUL för att skapa ny operativ uppgift.<br>
Här finns även producer som skickar requesten samt notifiering till OUL vid status-uppdatering.

_presentation/kafka_ innehåller consumer av response från OUL samt notifieringar av status-förändringar på uppgift.<br>
Definierar även interface OulHandlerInterface som gör det möjligt för regler att specificera regel-unik logik för
_handleOulStatus_ och _handleOulResponse_ via @Override.