export interface ParkingLot{
  id: number,
  name: string,
  available: boolean,
  customerName?: string,
  phoneNumber?: string,
  carNumber?: string,
  color?: string,
  startDate?: Date,
  expirationDate?: Date
}
