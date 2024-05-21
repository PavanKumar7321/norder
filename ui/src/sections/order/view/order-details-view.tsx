import { useState, useCallback } from 'react';

import Stack from '@mui/material/Stack';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Unstable_Grid2';

import { paths } from 'src/routes/paths';

import { useGetOrder } from 'src/api/order';
import { ORDER_STATUS_OPTIONS } from 'src/_mock';

import { useSettingsContext } from 'src/components/settings';

import OrderDetailsInfo from '../order-details-info';
import OrderDetailsItems from '../order-details-item';
import OrderDetailsToolbar from '../order-details-toolbar';
import OrderDetailsHistory from '../order-details-history';

// ----------------------------------------------------------------------

type Props = {
  id: string;
};

export default function OrderDetailsView({ id }: Props) {

  const { order, orderLoading, orderError } = useGetOrder(id);

  const settings = useSettingsContext();

  const [status, setStatus] = useState(order?.status);

  const handleChangeStatus = useCallback((newValue: string) => {
    setStatus(newValue);
  }, []);

  if (orderLoading) {
    return <div>Loading...</div>;
  }

  if (orderError || !order) {
    return <div>Error loading order or order not found</div>;
  }

  return (
    <Container maxWidth={settings.themeStretch ? false : 'lg'}>
      <OrderDetailsToolbar
        backLink={paths.dashboard.order.root}
        orderNumber={order.orderNumber}
        createdAt={order.createdAt}
        status={status}
        onChangeStatus={handleChangeStatus}
        statusOptions={ORDER_STATUS_OPTIONS}
      />

      <Grid container spacing={3}>
        <Grid xs={12} md={8}>
          <Stack spacing={3} direction={{ xs: 'column-reverse', md: 'column' }}>
            <OrderDetailsItems
              items={order.items}
              taxes={order.taxes}
              shipping={order.shipping}
              discount={order.discount}
              subTotal={order.subTotal}
              totalAmount={order.totalAmount}
            />

            <OrderDetailsHistory history={order.history} />
          </Stack>
        </Grid>

        <Grid xs={12} md={4}>
          <OrderDetailsInfo
            customer={order.customer}
            delivery={order.delivery}
            payment={order.payment}
            shippingAddress={order.shippingAddress}
          />
        </Grid>
      </Grid>
    </Container>
  );
}
