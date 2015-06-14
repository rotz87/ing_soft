In Proprietà->Deployment Assembly controllare che ci sia il file lib/orm.jar 
(probabilemente a causa di un bug la prima volta che viene settato o appena il progetto 
viene importato, viene cancellato questo setting. Il file di configurazione coinvolto 
è .settings/org.eclipse.wst.common.component);

In proprietà->Project Facets assicurarsi che nel tab Runtimes si selezionata 
l'istanza corretta del webServer.