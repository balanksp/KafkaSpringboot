Message from Kafka
------------------
1. user order the product --------Producer-----OrderService

2. vendor getting the orderDetails ---------consumer-------ProviderService

3. product is ready to dispatch ---Producer-------ProviderService

4. product received to user -------consumer----DeliveryService

used in services 
----------------
OrderService , ProviderService , DeliveryService

stacks 
------
maven       4
springBoot  2.7.13
postgresql 14
JpaRepo 


